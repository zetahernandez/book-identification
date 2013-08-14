var db = function () {
  
  var mongoose = require('mongoose'),
    dbPath = 'mongodb://localhost/books';

  mongoose.connect(dbPath, function onMongooseError(err) {
    if (err) {
      throw err;
    }
  });

  var models = {
    Volume: require('./volume')(mongoose)
  };
  return models;
};
exports.db = db;