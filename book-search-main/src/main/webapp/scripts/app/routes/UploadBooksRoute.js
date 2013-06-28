define(["ember"], function (Ember) {
	var UploadBooksRoute = Ember.Route.extend({
		renderTemplate: function () {
			this.render('index');
			this.render('header', {
				outlet: 'header',
				into: 'index'
			});
			this.render('uploadBooks', {
				outlet: 'center',
				into: 'index'
			});
		}
	});
	return UploadBooksRoute;
});