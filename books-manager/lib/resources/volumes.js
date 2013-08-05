var api = require('./');

function mapRoutes(app) {
  app.get('/api/volumes/:id', function (req, res) {
    var volumeId = req.param("id");
    
  });
  return app;
}
module.exports.mapRoutes = mapRoutes;