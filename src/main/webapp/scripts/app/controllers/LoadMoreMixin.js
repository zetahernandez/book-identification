define(["ember"], function(Ember){
	LoadMoreMixin = Ember.Mixin.create(Ember.Evented, {
		canLoadMore: true,
		autoFetch: true,
		currentPage: 0,
		resetLoadMore: function() {
			this.set('currentPage', 0);
		},
		loadMore: Ember.K
	});
	return LoadMoreMixin;
});
