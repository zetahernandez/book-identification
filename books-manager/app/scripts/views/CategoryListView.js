BooksManager.CategoryListView = Ember.View.extend({
  tagName: "ul",
  classNames: ["nav", "nav-list", "well"],
  defaultTemplate: Ember.Handlebars.compile(categoryListTemplate)
});