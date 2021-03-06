/**
 * The MIT License (MIT)

Copyright (c) 2013 Chute

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.getchute.android.photopickerplus.util.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.Iterator;

/**
 * {@link IntentWrapper} is a helper class that wraps up the Intent object and
 * its data.
 * 
 */
public class IntentWrapper {

  private final Intent intent;

  public IntentWrapper(Intent intent) {
    super();
    this.intent = intent;
  }

  public IntentWrapper(Context context, Class<?> cls) {
    super();
    this.intent = new Intent(context, cls);
  }

  public final Intent getIntent() {
    return intent;
  }

  /**
   * Always
   * 
   * @return true if there are extras in the intent, the bundle is <b>not</b>
   *         null or empty
   */
  public boolean hasExtras() {
    return intent.getExtras() != null && !intent.getExtras().isEmpty();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BaseIntentWrapper [");
    if (hasExtras()) {
      Iterator<String> it = intent.getExtras().keySet().iterator();
      while (it.hasNext()) {
        builder.append("Key: ");
        String key = it.next();
        builder.append(key);
        builder.append(" Value: ");
        builder.append(intent.getExtras().get(key).toString());
        builder.append("\n");
      }
    }
    builder.append(" ]");
    return builder.toString();
  }

  public void startActivity(Activity context) {
    context.startActivity(intent);
  }


}
