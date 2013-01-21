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

		viewAllCategories : function() {
				this.get('selectedCategories').clear();
				this.set('selectedCategory',null);
				var parents = BooksApp.Category.find().filter(function(category){
					return category.get('parent') == null;
				});
				this.set('content',parents );
				BooksApp.router.get('volumeListController').showAll();
		},
		
		selectCategory : function(categoryId) {
			var category = this.findProperty("id", parseInt(categoryId));
			if(category == null || category == undefined){
			    category = BooksApp.Category.find(categoryId);
			}
			this.set('selectedCategory',category);
			this.get('selectedCategories').set('content',this.selectCategories(this.get('selectedCategory'))); 
			this.set('content',this.get('selectedCategory').get('subCategories'));
			BooksApp.router.get('volumeListController').filterByCategory(this.get('selectedCategory'));
		},

	});
	return CategoryListController;
});