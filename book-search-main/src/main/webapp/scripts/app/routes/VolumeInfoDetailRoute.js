define(["ember"], function(Ember) {
	var VolumeInfoDetailRoute = Ember.Route.extend({

		renderTemplate: function(controller, model) {
			var categoryListController = this.controllerFor('categoryList');


			categoryListController.set('content', BooksApp.Category.find());


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
			this.render('volumeInfoDetail', {
				outlet: 'center',
				into: 'index',
				controller: 'volumeInfoDetail',
				model: model
			});
		},
		model: function(params) {
			return BooksApp.Volume.find(params.volume_id);
		}
	});
	return VolumeInfoDetailRoute;
});