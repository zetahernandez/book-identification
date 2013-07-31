BooksManager.VolumeInfoDetailView = Ember.View.extend({
  defaultTemplate: Ember.Handlebars.compile(volumeInfoDetailTemplate),
  didInsertElement: function () {
    Ember.$('.scrollable-content').animate({
      scrollTop: 0
    }, 2000);
  }
});