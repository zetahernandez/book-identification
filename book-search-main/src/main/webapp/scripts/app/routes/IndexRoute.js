define(["ember"], function (Ember) {
	var IndexRoute = Ember.Route.extend({

		renderTemplate: function (controller, model) {
			var categoryListController = this.controllerFor('categoryList'),
				volumeListController = this.controllerFor('volumeList');

			categoryListController.set('content', BooksApp.Category.find());
			volumeListController.set('content', BooksApp.Volume.find());

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
	return IndexRoute;
});