define(["ember", "text!templates/applicationTemplate.handlebars"], function (Ember, applicationTemplate) {
	var ApplicationView = Ember.View.extend({
		template: Ember.Handlebars.compile(applicationTemplate),
		classNames: ["application"],
	});
	return ApplicationView;
});