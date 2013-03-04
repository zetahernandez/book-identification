define(["ember"], function(Ember) {
	var UploadBooksRoute = Ember.Route.extend({
		renderTemplate: function() {
			this.render('uploadBooks', {
				outlet: 'center',
				into: 'index'
			});
		}
	});
	return UploadBooksRoute;
});