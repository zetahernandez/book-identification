var api = require('./'),
  models = require('../models').db();

function mapRoutes(app) {
  app.get('/api/volumes/:id', function (req, res) {
    debugger;
    var volumeId = req.param("id");
    res.send(volumeId);
  });

  app.post('/api/volumes', function (req, res) {
    debugger;
    models.Volume.addVolume(req.body);
    res.send('sarasa');
  });

  return app;
}
module.exports.mapRoutes = mapRoutes;