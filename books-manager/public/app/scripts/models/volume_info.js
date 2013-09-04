BooksManager.VolumeInfo = DS.Model.extend({
  authors: DS.attr(),
  description: DS.attr( ),
  imageLinks: DS.belongsTo('image-link'),
  industryIdentifiers: DS.hasMany('industry-identifier'),
  title: DS.attr('string'),
  subtitle: DS.attr('string'),
  publisher: DS.attr('string'),
  pages: DS.attr('number'),
  publishedDate: DS.attr('date'),
  categories: DS.hasMany('category'),

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