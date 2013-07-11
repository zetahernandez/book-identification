define(["ember"], function (Ember) {
	var SettingsUploadRoute = Ember.Route.extend({
		renderTemplate: function () {
			this.render('settings');
			this.render('header', {
				outlet: 'header',
				into: 'settings'
			});
			this.render('uploadBooks', {
				outlet: 'center',
				into: 'settings'
			});
		}
	});
	return SettingsUploadRoute;
});