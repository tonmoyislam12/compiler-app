/*
 *  Copyright (C)  2018  Duy Tran Le
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.duy.ide.diagnostic;

import java.util.ArrayList;

/**
 * Provides an easy way to collect diagnostics in a list.
 * <p>
 * Created by Duy on 28-Apr-18.
 */

public class DiagnosticsCollector implements DiagnosticListener {
    private final ArrayList<Diagnostic> diagnostics = new ArrayList<>();

    @Override
    public void report(Diagnostic diagnostic) {
        diagnostics.add(diagnostic);
    }

    @Override
    public void clear() {
        diagnostics.clear();
    }

    public ArrayList<Diagnostic> getDiagnostics() {
        return diagnostics;
    }
}