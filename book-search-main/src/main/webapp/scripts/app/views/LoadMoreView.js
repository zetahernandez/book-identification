define(["ember", "text!templates/loadMoreTemplate.handlebars"], function (Ember, loadMore) {

	LoadMoreView = Ember.View.extend({
		defaultTemplate: Ember.Handlebars.compile(loadMore),
		didInsertElement: function () {
			if (this.get('controller.autoFetch')) {
				var view = this;
				this.$().bind('inview', function (event, isInView, visiblePartX, visiblePartY) {
					if (isInView) Ember.tryInvoke(view.get('controller'), 'loadMore');
				});
			}
		}
	});
	return LoadMoreView;
});