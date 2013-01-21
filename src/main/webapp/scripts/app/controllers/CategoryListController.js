define([ "require", "ember" ], function(r, Ember) {
	var CategoryListController = Ember.ArrayController.extend({
		selectedCategory : null,
		
		selectedCategories : Ember.ArrayProxy.create({
		}),
		
		selectCategories : function(category) {
			var categories = [];
			if(category != null && category != undefined && category.get('parent')){
				categories = categories.concat(this.selectCategories(category.get('parent')));
			}
			categories.push(category);
			return categories;
		},

		selectCategory : function(categoryId) {
			BooksApp.VolumeListController.filteByCategory(this.get('selectedCategories').get('id'));
			this.set('selectedCategory',this.findProperty("id", parseInt(categoryId)));
			this.get('selectedCategories').set('content',this.selectCategories(this.get('selectedCategory'))); 
			this.set('content',this.get('selectedCategory').get('subCategories'));
		},

	});
	return CategoryListController;
});