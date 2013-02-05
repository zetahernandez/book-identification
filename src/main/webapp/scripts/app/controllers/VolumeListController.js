define([ "require", "ember", "controllers/LoadMoreMixin" ], function(r, Ember,LoadMoreMixin) {
	var VolumeListController = Ember.ArrayController.extend(
			LoadMoreMixin, {
				category : null,
				query : {},
				canLoadMore : function() {
					return this.get('currentPage') < 10;
				}.property('currentPage'),

				loadMore : function() {
					if (this.get('canLoadMore')) {
						var page = this.incrementProperty('currentPage');
						this.get('target').send('loadMoreVolumes', page);
					}
				},
				loadingComplete:function(){
					BooksApp.router.set('volumeListController.isLoading', false);
					BooksApp.router.set('volumeListController.content',BooksApp.store.find(BooksApp.Volume));
				}.observes('content.isLoaded'), 
				
				filterByCategory : function(category) {
					this.category = category;
					var content = BooksApp.Volume.find({
						"categoryId" : category.get('id'),
						"page" : 1
					});
					this.set('content', content);
				},

				showAll : function() {
					this.set("page", 1);
					this.set('content', BooksApp.Volume.find({
						"page" : 1
					}));
				},

				showVolumeInfo : function(event) {
					BooksApp.router.applicationController.connectOutlet({
						name : 'volumeInfoDetail',
						context : event.context,
						outletName : 'center'
					});
				},
			});
	return VolumeListController;
});