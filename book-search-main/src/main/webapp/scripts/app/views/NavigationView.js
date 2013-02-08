define(["ember", "text!templates/navigationTemplate.handlebars"], function (Ember, navigationTemplate) {
	var NavigationView = Ember.View.extend({
		template: Ember.Handlebars.compile(navigationTemplate),
		classNames: ['navigation']
	});
	return NavigationView;
});