var mongoose = require('mongoose'),
  Schema = mongoose.Schema,
  ObjectId = Schema.ObjectId;
mongoose.connect('mongodb://localhost/test');

var VolumeSchema = new Schema({
  kind: String,
  id: ObjectId,
  etag: String,
  selfLink: String,
  volumeInfo: {
    title: String,
    authors: [String],
    publisher: String,
    publishedDate: Number,
    description: String,
    industryIdentifiers: [{
      type: String,
      identifier: String
    }],
    pageCount: Number,
    printType: String,
    averageRating: String,
    ratingsCount: Number,
    contentVersion: String,
    imageLinks: {
      smallThumbnail: String,
      thumbnail: String
    },
    language: String,
    previewLink: String,
    infoLink: String,
    canonicalVolumeLink: String
  },
  saleInfo: {
    country: String,
    saleability: String,
    isEbook: Boolean
  },
  accessInfo: {
    country: String,
    viewability: String,
    embeddable: Boolean,
    publicDomain: Boolean,
    textToSpeechPermission: String,
    epub: {
      isAvailable: Boolean
    },
    pdf: {
      isAvailable: Boolean
    },
    webReaderLink: String,
    accessViewStatus: String
  },
  searchInfo: {
    textSnippet: String
  }
});

module.exports = mongoose.model('Volume', VolumeSchema);