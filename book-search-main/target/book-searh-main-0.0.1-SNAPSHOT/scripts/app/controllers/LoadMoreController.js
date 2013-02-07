define([ "require", "ember" ], function(r, Ember) {
	var LoadMoreController = Ember.ArrayController.extend({
		more : function() {
			if(this.get('content') != null && this.get('content').isLoaded){
				if(BooksApp.router.get('volumeListController.content') == null){
					BooksApp.router.set('volumeListController.content',this.get('content'));
				}else{
					this.get('content').forEach(function(volume){
						 BooksApp.router.get('volumeListController').addVolume(volume);
					});
				}
				BooksApp.router.set('loadMoreController.isLoading',false);
			}
		}.observes('content','content.isLoaded'),
	});
	return LoadMoreController;
});
