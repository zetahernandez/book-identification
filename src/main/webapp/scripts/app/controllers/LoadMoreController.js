define([ "require", "ember" ], function(r, Ember) {
	var LoadMoreController = Ember.ArrayController.extend({
		
		more : function() {
			console.log(this.get('content') != null && this.get('content').isLoaded);
			if(this.get('content') != null && this.get('content').isLoaded){
				if(BooksApp.router.get('volumeListController.content') == null){
					console.log(this.get('content'));
					BooksApp.router.set('volumeListController.content',this.get('content'));
				}else{
					console.log(this.get('content'));
					this.get('content').forEach(function(volume){
						console.log(volume);
						 BooksApp.router.get('volumeListController').addVolume(volume);
					});
				}
				BooksApp.router.set('loadMoreController.isLoading',false);
			}
		}.observes('content','content.isLoaded'),
	});
	return LoadMoreController;
});
