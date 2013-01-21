define([ "require", "ember"], function(r,Ember) {
	var VolumeListController = Ember.ArrayController.extend({
		filterByCategory : function(category) {
			this.set('content',	BooksApp.Volume.find({categoryId: category.get('id')}));
		},
		showAll : function() {
			this.set('content',	BooksApp.Volume.find());
		}
	});
	return VolumeListController;
});