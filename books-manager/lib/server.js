/**
 * Module dependencies.
 */

var express = require('express'),
  http = require('http'),
  path = require('path'),
  mongoose = require('mongoose'),
  dbPath = 'mongodb://localhost/nodebackbone',
  api = require('./resources');

var app = express();

var models = {
  Volume: require('./models/volume')(mongoose)
};
// all environments
app.set('port', process.env.PORT || 3000);

app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.disable('strict routing');
app.use(app.router);

app.use(express.errorHandler());

// development only
if ('production' === app.get('env')) {
  app.use(express.static(path.join(__dirname, '../public/dist')));
} else {
  app.use(express.static(path.join(__dirname, '../public/app')));
  app.use(express.static(path.join(__dirname, '../public/.tmp')));
}
app = api.base.mapRoutes(app,models);
app = api.volumes.mapRoutes(app,models);

mongoose.connect(dbPath, function onMongooseError(err) {
  if (err) throw err;
});

http.createServer(app).listen(app.get('port'), function () {
  console.log("Express server listening on port %d in %s mode", app.get('port'), app.get('env'));
});