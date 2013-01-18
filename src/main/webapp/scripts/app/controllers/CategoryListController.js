define([ "require", "ember"], function(r,Ember) {
	var CategoryListController = Ember.ArrayController.extend({
	selectedCategory : null,	
  
	selectCategory  : function(event) {
			console.log(event);
		 	return event;
		},
	
    subcategories :  function() {
		    var sub = this.filter(function(category) {
		        return category.get('subCategories');
		      });
		      return sub;
		    }.property()
		    
		    
	});
	return CategoryListController;
});