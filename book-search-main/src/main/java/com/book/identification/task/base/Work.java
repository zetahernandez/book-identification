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

package com.book.identification.task.base;

public abstract class Work<I extends ItemQueue> extends Thread {

	public Work() {
		super();
	}

	public Work(Runnable target, String name) {
		super(target, name);
	}

	public Work(Runnable target) {
		super(target);
	}

	public Work(String name) {
		super(name);
	}

	public Work(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
	}

	public Work(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public Work(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public Work(ThreadGroup group, String name) {
		super(group, name);
	}

}
