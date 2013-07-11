define(["ember"], function (Ember) {
	var SettingsGeneralRoute = Ember.Route.extend({
		renderTemplate: function () {
		    this.render('settings');
			this.render('header', {
				outlet: 'header',
				into: 'settings'
			});
			this.render('settingsGeneral', {
				outlet: 'center',
				into: 'settings'
			});
		}
	});
	return SettingsGeneralRoute;
});