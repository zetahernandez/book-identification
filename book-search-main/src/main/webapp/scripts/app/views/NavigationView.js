define(["ember", "text!templates/navigationTemplate.handlebars"], function (Ember, navigationTemplate) {
	var NavigationView = Ember.View.extend({
		defaultTemplate: Ember.Handlebars.compile(navigationTemplate),
		classNames: ['navigation']
	});
	return NavigationView;
});