define([
	"ember",
	"text!templates/categoryTemplate.handlebars"
], function(Ember,category){
	var CategoryView = Ember.View.extend({
		category: null,  
		tagName: "li",
	  classNames: ["category-item"],
	  template: Ember.Handlebars.compile(category),
	  
	  	click  : function(event,context) {
			console.log(event);
		 	return event;
		}
	});
	return CategoryView;
});
