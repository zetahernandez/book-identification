define(["ember"], function (Ember) {
  var VolumeInfoDetailRoute = Ember.Route.extend({

    renderTemplate: function (controller, model) {
      this.render('index');
      this.render('volumeInfoDetail', {
        outlet: 'center',
        into: 'index',
        controller: 'volumeInfoDetail',
        model: model
      });
    },
    model: function (params) {
      return BooksApp.Volume.find(params.volume_id);
    }
  });
  return VolumeInfoDetailRoute;
});