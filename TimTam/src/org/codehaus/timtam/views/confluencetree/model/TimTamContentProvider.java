/*
 * Created on Oct 23, 2004
 *
 * 
 * Copyright (c) Zohar Melamed All rights reserved.
 * 
 * 
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided that the
 * following conditions are met:
 * 
 * 1. Redistributions of source code must retain copyright statements and
 * notices. Redistributions must also contain a copy of this document.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * 3. Due credit should be given to The Codehaus and Contributors
 * http://timtam.codehaus.org/
 * 
 * THIS SOFTWARE IS PROVIDED BY THE CODEHAUS AND CONTRIBUTORS ``AS IS'' AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE CODEHAUS OR ITS CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 *  
 */

package org.codehaus.timtam.views.confluencetree.model;

import org.codehaus.timtam.model.TimTamModel;
import org.codehaus.timtam.model.adapters.TreeAdapter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Sarah
 *  
 */
public class TimTamContentProvider implements ITreeContentProvider {
	public Object[] getChildren(Object parentElement) {
		TreeAdapter adapter = (TreeAdapter) parentElement;
		return adapter.getChildren();
	}

	public Object getParent(Object element) {
		TreeAdapter adapter = (TreeAdapter) element;
		return adapter.getParent();
	}

	public boolean hasChildren(Object element) {
		TreeAdapter adapter = (TreeAdapter) element;
		return adapter.hasChildren();
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof TimTamModel) {
			TimTamModel root = (TimTamModel) inputElement;
			return root.getServers();
		}
		TreeAdapter adapter = (TreeAdapter) inputElement;
		return adapter.getChildren();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//like i care ...
	}
}