define(["ember"], function(Ember){
	LoadMoreMixin = Ember.Mixin.create(Ember.Evented, {
		canLoadMore: false,
		autoFetch: true,
		currentPage: 0,
		query : {},
		resetLoadMore: function() {
			this.set('currentPage', 0);
		},
		loadMore: Ember.K
	});
	return LoadMoreMixin;
});
