define(["ember", "text!templates/headerTemplate.handlebars"], function (
Ember, headerTemplate) {
	var HeaderView = Ember.View.extend({
		template: Ember.Handlebars.compile(headerTemplate),
		classNames: ['header']
	});
	return HeaderView;
});