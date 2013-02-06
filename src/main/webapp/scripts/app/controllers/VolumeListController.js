define([ "require", "ember", "controllers/LoadMoreMixin" ], function(r, Ember,LoadMoreMixin) {
	var VolumeListController = Ember.ArrayController.extend(
			LoadMoreMixin, {
				canLoadMore : function() {
					var mod10 = 0;
					if(this.get('content')!= undefined){
						mod10 = this.get('content').length % 10;
					}
					return !this.get('isLoading') && mod10 == 0 ;
				},

				loadMore : function() {
					if (this.get('canLoadMore')) {
						var page = this.incrementProperty('currentPage');
						this.get('target').send('loadMoreVolumes', page);
					}
				},
			
				contentChanged: function() {
					console.log(this.get('content'));
				    var mutableVolumes = [];

				    this.get('content').forEach(function(volume) {
				    	mutableVolumes.pushObject(volume);
				    });

				    this.set('isLoading', false);
				    this.set('currentVolumes', mutableVolumes);
				}.observes('content', 'content.isLoaded'),
				
				addVolume: function(volume) {
				    this.get('currentVolumes').pushObject(volume);
				},

				removeVolume: function(volume) {
				    this.get('currentVolumes').forEach(function(item, i, currentVolumes) {
				        if (item.get('id') == comment.get('id')) {
				        	currentVolumes.removeAt(i, 1);
				        }
				    });
				},
				
				searchVolumes : function(textSearch) {
					this.set('isLoading', true);
					this.set('currentPage',1);
					this.set('query',{q : textSearch,page : 1});
					this.set('content', BooksApp.Volume.find(this.get('query')));
				},
				
				filterByCategory : function(category) {
					this.set('isLoading', true);
					this.category = category;
					this.set('currentPage',1);
					this.set('query',{categoryId : category.get('id'),page : 1});
					this.set('content', BooksApp.Volume.find(this.get('query')));
				},

				showAll : function() {
					this.set('isLoading', true);
					this.set('currentPage',1);
					this.set('query',{page : 1});
					this.set('content', BooksApp.Volume.find(this.get('query')));
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