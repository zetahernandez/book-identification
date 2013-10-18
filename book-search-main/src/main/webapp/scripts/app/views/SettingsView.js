define(["ember", "text!templates/settingsTemplate.handlebars"], function (Ember, settingsTemplate) {
	var SettingsView = Ember.View.extend({
		defaultTemplate: Ember.Handlebars.compile(settingsTemplate),
		classNames: ["asd"]
	});
	return SettingsView;
});