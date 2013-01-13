define([
	"ember",
	"text!templates/categoryListTemplate.handlebars"
], function(Ember,categoryList){
	var CategoryListView = Ember.View.extend({
	  template: Ember.Handlebars.compile(categoryList)
	});
	return CategoryListView;
});
