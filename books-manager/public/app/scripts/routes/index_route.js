BooksManager.IndexRoute = Ember.Route.extend({

  renderTemplate: function (controller, model) {
    var categoryListController = this.controllerFor('categoryList'),
      volumeListController = this.controllerFor('volumeList'),
      categories = this.get('store').findAll('category'),
      volumes = this.get('store').findAll('volume');

    categoryListController.set('model', categories);
    volumeListController.set('model', volumes);

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