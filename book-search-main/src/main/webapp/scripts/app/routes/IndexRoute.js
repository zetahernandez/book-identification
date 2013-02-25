define(["ember"], function (Ember) {
	var IndexRoute = Ember.Route.extend({

		renderTemplate: function () {
			console.log(this.get('controller.volumes'));
			this.render('volumeList', {
				outlet: 'center',
				controller: 'volumeList',
				model : this.get('controller.volumes')

			});

		},
		setupController: function (controller) {
			// Set the IndexController's `title`
			controller.set('volumes', BooksApp.Volume.find());
			// controller.set('categories', BooksApp.Category.find());
		}

	});
	return IndexRoute;
});