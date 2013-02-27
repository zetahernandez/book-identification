define(["require", "ember", "controllers/LoadMoreMixin"], function (r, Ember, LoadMoreMixin) {
	var VolumeListController = Ember.ArrayController.extend(
	LoadMoreMixin, {
		content:[],
		currentVolumes:[],
		
		canLoadMore: function () {
			var mod10 = 0;
			if(this.get('content') !== undefined) {
				mod10 = this.get('content').length % 10;
			}
			console.log(this.get('isLoading') && mod10 === 0);
			return !this.get('isLoading') && mod10 === 0;
		},

		loadMore: function () {
			if(this.get('canLoadMore')) {
				var page = this.incrementProperty('currentPage');
				this.loadMoreVolumes(page);
			}
		},

		contentChanged: function () {
			var mutableVolumes = [];
			console.log(this.get('content'));
			this.get('content').forEach(function (volume) {
				mutableVolumes.pushObject(volume);
			});

			this.set('isLoading', false);
			this.set('currentVolumes', mutableVolumes);
		}.observes('content.isLoaded'),

		addVolume: function (volume) {
			this.get('currentVolumes').pushObject(volume);
		},

		removeVolume: function (volume) {
			this.get('currentVolumes').forEach(function (item, i, currentVolumes) {
				if(item.get('id') == comment.get('id')) {
					currentVolumes.removeAt(i, 1);
				}
			});
		},

		searchVolumes: function (textSearch) {
			this.set('isLoading', true);
			this.set('currentPage', 1);
			this.set('query', {
				q: textSearch,
				page: 1
			});
			this.set('content', BooksApp.Volume.find(this.get('query')));
		},

		filterByCategory: function (category) {
			this.set('isLoading', true);
			this.category = category;
			this.set('currentPage', 1);
			this.set('query', {
				categoryId: category.get('id'),
				page: 1
			});
			this.set('content', BooksApp.Volume.find(this.get('query')));
		},

		showAll: function () {
			this.set('isLoading', true);
			this.set('currentPage', 1);
			this.set('query', {
				page: 1
			});
			this.set('content', BooksApp.Volume.find(this.get('query')));
		},

		showVolumeInfo: function (event) {
			BooksApp.router.applicationController.connectOutlet({
				name: 'volumeInfoDetail',
				context: event.context,
				outletName: 'center'
			});
		},
		loadMoreVolumes: function (page) {
				this.set('isLoading', true);
				this.set('query.page', page);
				this.set('moreVolumes', BooksApp.store.findQuery(BooksApp.Volume, this.get('query')));
		},
		more: function () {
			_self = this;
			if(this.get('moreVolumes') !== null && this.get('moreVolumes').isLoaded) {
				if(this.get('content') === null) {
					this.set('content', this.get('moreVolumes'));
				} else {
					this.get('moreVolumes').forEach(function (volume) {
						_self.addVolume(volume);
					});
				}
				this.set('isLoading', false);
			}
		}.observes('moreVolumes', 'moreVolumes.isLoaded'),
		openVolume : function(volume) {
			var volumeInfoView = BooksApp.VolumeInfoDetailView.create();
			volumeInfoView.appendTo('#modal');
			Ember.$('#modal').modal();
		}
	});
	return VolumeListController;
});