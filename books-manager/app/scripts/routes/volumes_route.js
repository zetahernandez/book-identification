BooksManager.VolumesRoute = Ember.Route.extend({
  renderTemplate: function (controller, model) {
    var categoryListController = this.controllerFor('categoryList'),
      volumeListController = this.controllerFor('volumeList');

    categoryListController.set('content', BooksManager.Category.find());
    volumeListController.set('content', BooksManager.Volume.find());
    this.render('index');
    this.render('header', {
      outlet: 'header',
      into: 'index'
    });
    this.render('categoryList', {
      outlet: 'left',
      into: 'index',
      controller: categoryListController
    });
    this.render('volumeList', {
      outlet: 'center',
      into: 'index',
      controller: volumeListController
    });
  }
});