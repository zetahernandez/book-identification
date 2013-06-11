define(["ember", "ember_data"], function (Ember, DS) {
  var Volumeinfo = DS.Model.extend({
    authors: DS.attr('string'),
    description: DS.attr('string'),
    imageLinks: DS.belongsTo('BooksApp.ImageLink'),
    industryIdentifiers: DS.hasMany('BooksApp.IndustryIdentifier'),
    title: DS.attr('string'),
    subtitle: DS.attr('string'),
    publisher: DS.attr('string'),
    pages: DS.attr('number'),
    publishedDate: DS.attr('date'),
    categories: DS.hasMany('BooksApp.Category'),

    unescapedDescription: function () {
      return this.get('description').htmlSafe();
    }.property('description'),

    formattedPublishedDate: function () {
      if (this.get('publishedDate')) {
        return this.get('publishedDate').getUTCDay() + "/" + (this.get('publishedDate').getUTCMonth() + 1) + "/" + this.get('publishedDate').getUTCFullYear();
      }

      return '';
    }.property('publishedDate').cacheable()

  });
  return Volumeinfo;
});