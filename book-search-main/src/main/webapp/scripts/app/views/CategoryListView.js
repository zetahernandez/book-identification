define(["ember", "text!templates/categoryListTemplate.handlebars"], function (Ember, categoryList) {
	var CategoryListView = Ember.View.extend({
		tagName: "ul",
		classNames: ["nav nav-list"],
		defaultTemplate: Ember.Handlebars.compile(categoryList)
	});
	return CategoryListView;
});