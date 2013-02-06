define([ "require", "ember" ], 
		function() {
	var SearchVolumeController = Ember.ObjectController.extend({
		searchText : '',
		
		searchVolumes : function() {
			BooksApp.router.get('volumeListController').searchVolumes(this.get('searchText'));
		}
		
	});
	return SearchVolumeController;
});