BooksManager.VolumeInfoDetailRoute = Ember.Route.extend({

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
    return BooksManager.Volume.find(params.volume_id);
  }
});