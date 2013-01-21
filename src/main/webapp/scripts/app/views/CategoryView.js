define([
	"ember",
], function(Ember){
	var CategoryView = Ember.View.extend({
		category: null,  
		tagName: "li",
		classNames: ["category-item"],
		
		click: function(event){
			 var categoryId = event.target.id;
			 if(categoryId == "allCategories"){
				 this.get('content').viewAllCategories();
			 }else{
				 this.get('content').selectCategory(categoryId);
			 }
		 }
	});
	return CategoryView;
});
