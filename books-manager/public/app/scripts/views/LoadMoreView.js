BooksManager.LoadMoreView = Ember.View.extend({
  templateName: 'loadMoreTemplate',
  didInsertElement: function () {
    if (this.get('controller.autoFetch')) {
      var view = this;
      this.$().bind('inview', function (event, isInView, visiblePartX, visiblePartY) {
        if (isInView) Ember.tryInvoke(view.get('controller'), 'loadMore');
      });
    }
  }
});