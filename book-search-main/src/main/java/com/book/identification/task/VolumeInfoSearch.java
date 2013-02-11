// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification.task;

import java.util.concurrent.BlockingQueue;

import com.book.identification.BookFile;
import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerConsumer;
import com.book.identification.task.base.ProducerConsumerManager;
import com.book.identification.task.base.ProducerThread;

public class VolumeInfoSearch extends ProducerConsumerManager<ProducerThread<Volume>, Volume, BookFile> {


	public VolumeInfoSearch(String name, BlockingQueue<BookFile> input,
			BlockingQueue<Volume> output, ProducerConsumer nextProducerConsumer) {
		super(name, input, output, nextProducerConsumer);
	}


	@Override
	protected ProducerThread<Volume> createConsumerWork(BookFile take,
			BlockingQueue<Volume> output) {
		return new ISBNRequest(take,output);
	}


	@Override
	protected boolean acceptWork(BookFile item) {
		return true;
	}

}
