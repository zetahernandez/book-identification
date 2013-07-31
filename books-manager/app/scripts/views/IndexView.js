BooksManager.IndexView = Ember.View.extend({
  defaultTemplate: Ember.Handlebars.compile(indexTemplate),
  classNames: ["max-height", "no-overflow"]
});