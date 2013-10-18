define(["ember"], function (Ember) {
	var SettingsGeneralRoute = Ember.Route.extend({
		renderTemplate: function () {
		 	this.render('settingsGeneral', {
				outlet: 'center',
				into: 'settings'
			});
		}
	});
	return SettingsGeneralRoute;
});