define([
	"ember",
	"text!templates/categoryListTemplate.handlebars"
], function(Ember,categoryList){
	var CategoryListView = Ember.View.extend({
	  tagName: "ul",
	  classNames: ["category-list"],
	  template: Ember.Handlebars.compile(categoryList),
	});
	return CategoryListView;
});
