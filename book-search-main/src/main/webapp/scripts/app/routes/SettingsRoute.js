define(["ember"], function (Ember) {
	var SettingsRoute = Ember.Route.extend({
		renderTemplate: function () {
			this.render('settings');
			this.render('header', {
				outlet: 'header',
				into: 'settings'
			});
			this.render('settingsGeneral', {
				outlet: 'settingContent',
				into: 'settings'
			});
		}
	});
	return SettingsRoute;
});