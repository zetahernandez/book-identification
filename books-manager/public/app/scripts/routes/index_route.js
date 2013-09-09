BooksManager.IndexRoute = Ember.Route.extend({

  renderTemplate: function (controller, model) {
    var categoryListController = this.controllerFor('categoryList'),
      volumeListController = this.controllerFor('volumeList');
    // categories = BooksManager.Volume.findAll(),

    BooksManager.Volume.findAll().then(function (volumes) {
      volumeListController.set('model', volumes);
    });

    // categoryListController.set('model', categories);

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