define(["ember"], function (Ember) {
	var SettingsRoute = Ember.Route.extend({
		renderTemplate: function () {
			this.render('settings');
			this.render('header', {
				outlet: 'header',
				into: 'settings'
			});
		}
	});
	return SettingsRoute;
});