define([
	"ember",
], function(Ember){
	var CategoryView = Ember.View.extend({
		category: null,  
		tagName: "li",
		classNames: ["category-item"],
		
		click: function(event){
			 var categoryId = event.target.id;
			 //this return categeryListController
			 this.get('content').selectCategory(categoryId);
		 }
	});
	return CategoryView;
});
